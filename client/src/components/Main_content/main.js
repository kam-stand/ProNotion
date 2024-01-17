import Pricing from "../pricing/pricing";
import Product from "../product_details/product";

export default function Main(){
    return(
        <>
        <section>
            <div className="informational">
                <Product/>
            </div>
            <div className="prices">
                <Pricing/>
            </div>
        </section>
        </>
    )
}