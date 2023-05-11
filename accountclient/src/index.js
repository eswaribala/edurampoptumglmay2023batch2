import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { createClient } from 'graphql-ws';
import { setContext } from '@apollo/client/link/context';
import {
    ApolloClient,
    InMemoryCache,
    ApolloProvider, HttpLink, split,

} from "@apollo/client";
import {GraphQLWsLink} from "@apollo/client/link/subscriptions";
import {getMainDefinition} from "@apollo/client/utilities";


const httpLink = new HttpLink({
    uri: 'http://localhost:7070/graphql'
});
const wsLink = new GraphQLWsLink(createClient({
    url: 'ws://localhost:7070/graphql',
}));

const splitLink = split(
    ({ query }) => {
        const definition = getMainDefinition(query);
        return (
            definition.kind === 'OperationDefinition' &&
            definition.operation === 'subscription'
        );
    },

    httpLink,
);



const authLink = setContext((_, { headers }) => {
    // get the authentication token from local storage if it exists
    //const token = localStorage.getItem('token');
    const token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJlc3dhcmliYWxhIiwicm9sZXMiOlsiUk9MRV9BRE1JTiJdLCJpYXQiOjE2ODM4MjU2NjMsImV4cCI6MTY4MzgyNTg0M30.jmd2kkFHh5Xs7dwM_FoI5JAzJPBG3xRzvlnnJw00erp8rA995nSOhGlcarhjDFEDz5oMe9Qt5A1qouKDm2ufCQ"
    // return the headers to the context so httpLink can read them
    return {
        headers: {
            ...headers,
            authorization: token ? `Bearer ${token}` : "",
        }
    }
});

const client = new ApolloClient({
    link: authLink.concat(httpLink),
    cache: new InMemoryCache(),
    wsLink,
    httpLink
});

/*const client = new ApolloClient({
     uri: 'http://localhost:7070/graphql/',
    cache: new InMemoryCache(),
    wsLink,
    httpLink
});*/
ReactDOM.render(
  <React.StrictMode>
      <ApolloProvider client={client}>
          <App />
      </ApolloProvider>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
