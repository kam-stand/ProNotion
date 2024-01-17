export default function Pricing(){
    return(
        <>
        <div className="wrapper-pricing">
        <div className="pricing">
                <div className="price-list">
                    <h1 className="plan">Basic</h1>
                    <p>Task</p>
                    <p>Events</p>
                    <p>Reminders</p>
                    <hr></hr>
                    <h2>$15.99</h2>
                </div>
            </div>    

            <div className="pricing">
                <div className="price-list">
                    <h1 className="plan">Pro</h1>
                    <p>Task</p>
                    <p>Events</p>
                    <p>Reminders</p>
                    <p>Calendar</p>
                    <hr></hr>
                    <h2>$20.99</h2>
                </div>
            </div> 

            <div className="pricing">
                <div className="price-list">
                    <h1 className="plan">Advanced</h1>
                    <p>Task</p>
                    <p>Events</p>
                    <p>Reminders</p>
                    <p>Calendar</p>
                    <p>Project roadmap</p>
                    <hr></hr>
                    <h2>$27.99</h2>
                </div>
            </div>   
            </div>
        </>
    )

}