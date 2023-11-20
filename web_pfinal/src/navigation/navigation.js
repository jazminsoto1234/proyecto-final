import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "../pages/Home";
import Cart from "../pages/Cart";
import { useSelector } from "react-redux";
import { cartProducts } from "../stores/cart/cartStore";
import { Footer } from "../components/Footer";
import {NavBar} from "../components/NavBar";


import Login from "../pages/Login";
import Register from "../pages/Register";


const Navigation = () => {
    const productsInCart = useSelector(cartProducts);

    return (
        <BrowserRouter>
        <NavBar />
        <Routes>
          {/* Rutas separadas para Login y Register */}
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
  
          {/* Resto de las rutas */}
          <Route path="/" element={<Home />} />
          <Route path="/cart" element={<Cart />} />
          {/* Otras rutas */}
        </Routes>
        <Footer />
        </BrowserRouter>
    )
}

export default Navigation;