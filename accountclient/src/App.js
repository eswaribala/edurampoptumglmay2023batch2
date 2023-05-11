import logo from './logo.svg';
import './App.css';
import TransactionList from "./Pages/TransactionList";
import CreateTransaction from "./Pages/CreateTransaction";
import CreateTransactionSubscription from "./Pages/CreateTransactionSubscription";

function App() {

  return (
    <div className="App">
    <CreateTransaction/>
    <TransactionList/>
    <CreateTransactionSubscription/>
    </div>
  );
}
export default App;
