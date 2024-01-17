import clock from "../../images/clock.png"
export default function Product(){
    return(
        <>
        <div className="product">
           <div className="task-list">
            <h1>Task</h1>
            <div >
                <label>Important!!</label>
                <input type="text" placeholder="Lets go!!!"/>
            </div>
            <div>
            <img
            alt="clock"
            src={clock}
            />
            <label>Set reminders</label>
            <input type="date" placeholder="when is this due?"/>
            </div>
           </div>

        </div>
        
        
        </>
    )
}