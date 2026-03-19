import React,{useEffect,useState} from "react";
import { getUserNotifications } from "../api/notification.api";

export default function NotificationPanel(){

const [notifications,setNotifications] = useState([]);

const userId = localStorage.getItem("userId");

useEffect(()=>{

 getUserNotifications(userId)
  .then(res=>setNotifications(res.data));

},[]);

return(

<div className="notification-panel">

<h3>🔔 Notifications</h3>

{notifications.map(n=>(
<div key={n.id} className="notification-card">
{n.message}
</div>
))}

</div>

);

}