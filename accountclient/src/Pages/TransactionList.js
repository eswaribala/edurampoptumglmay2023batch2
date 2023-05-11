import React from 'react'
import {useQuery,gql} from "@apollo/client";
const GET_TRANSACTIONS=gql `
    query{
        showTransactions{
            amount
            timeStamp
            sender
            receiver
        }
    }
`
export default function TransactionList(){
    const {error,data,loading}=useQuery(GET_TRANSACTIONS);
    console.log({error,data,loading});
   if (loading) return <div>spinner....</div>
   if (error)  return <div>OOPS!!!!!!!!!!</div>
return <div>
    <h1>Transaction Details</h1>
    <table border="1" >
     <thead>
     <th>
         Amount
     </th>
     <th>
         Time Stamp
     </th>
     <th>
         Sender
     </th>
     <th>
         Receiver
     </th>

     </thead>
    <tbody>
    {
        data.showTransactions.map(transaction=>{
            return(
                <tr key={transaction.amount}>
                    <td>{transaction.amount}</td>
                    <td>{transaction.timeStamp}</td>
                    <td>{transaction.sender}</td>
                    <td>{transaction.receiver}</td>
                </tr>
            )
        })
    }
    </tbody>
    </table>
</div>
}
