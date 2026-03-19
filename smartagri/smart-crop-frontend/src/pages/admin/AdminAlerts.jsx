import React,{useState} from "react";
import { sendNotification } from "../../api/notification.api";

export default function AdminAlerts(){

const [userId,setUserId] = useState("");
const [message,setMessage] = useState("");

const send = async ()=>{

 await sendNotification({
   userId,
   message
 });

 alert("Notification Sent");

 setMessage("");
};

return(

<div className="dashboard-wrapper">

<h2>📢 Send Alert to Farmer</h2>

<input
placeholder="User ID"
value={userId}
onChange={(e)=>setUserId(e.target.value)}
/>

<textarea
placeholder="Alert message"
value={message}
onChange={(e)=>setMessage(e.target.value)}
/>

<button onClick={send}>
Send Notification
</button>

</div>

);

}