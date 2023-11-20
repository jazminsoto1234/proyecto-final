import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "../pages/Home";
import Login from "../pages/Login";
import Register from "../pages/Register";
import Cart from "../pages/Cart";
import { useSelector } from "react-redux";
import { cartProducts } from "../stores/cart/cartStore";
import { Footer } from "../components/Footer";
import {NavBar} from "../components/NavBar";

const Navigation = () => {
    const productsInCart = useSelector(cartProducts);

    return (
        <BrowserRouter>
            <NavBar />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register />} />
                <Route path="/cart" element={<Cart />} />
            </Routes>
            <Footer />
        </BrowserRouter>
    )
}

export default Navigation;