import { Tabs } from "../components/Tabs";
import Button from "../components/elements/Button";
import { useSelector } from "react-redux";
import { cartProducts } from "../stores/cart/cartStore";
import useTabSwitch from "../hooks/useTabSwitch";
import { AddressForm } from "../components/addressForm";
import { ProductsSummary } from "../components/ProductsSummary";
import { StripeWrapper } from "../components/PaymentForm";
import { ReactComponent as ArrowRightSvg } from "../assets/icons/arrow-right-long-svgrepo-com.svg";
import "../styles/Cart.css"
const Cart = () => {
    const cart = useSelector(cartProducts);
    const tabs= ['Summary', 'Delivery', 'Payment'];
    const [currentTab, handleTabSwitch] = useTabSwitch(tabs, 'Summary');

    if (!cart || cart.length === 0) {
        return (
            <div className = "cart-container">
                <h1>Your Cart is empty</h1>
            </div>
        )
    }

    return (
        <div className="cart-container">
            <Tabs list={tabs} onTabSwitch={handleTabSwitch} activeTab={currentTab} />
            <div className={`tabs ${currentTab !== 'Summary' ? 'hidden' : ''}`}>
                <ProductsSummary />
                <div className="next-button">
                    <Button variant="dark" className="button button-dark" onClick={()=>handleTabSwitch('Delivery')}>
                        <span>Next</span>
                        <ArrowRightSvg className="arrow-icon" />
                    </Button>
                </div>
            </div>
            <div className={`tabs ${currentTab !== 'Delivery' ? 'hidden' : ''}`}>
                <AddressForm onTabSwitch={handleTabSwitch}/>
            </div>
            <div className={`tabs ${currentTab !== 'Payment' ? 'hidden' : ''}`}>
                <StripeWrapper />
            </div>
        </div>
    )
}

export default Cart;
