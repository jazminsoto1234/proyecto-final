import { combineReducers } from "redux";
import cartReducer from "./cart/cartStore";
import productsReducer from "./Products/cookieStore";
import addressReducer from "./userInfo/addressStore";
import orderReducer from "./Order/orderStore";

const rootReducer = combineReducers({
    cart: cartReducer,
    products: productsReducer,
    address: addressReducer,
    order: orderReducer
});

export default rootReducer;
