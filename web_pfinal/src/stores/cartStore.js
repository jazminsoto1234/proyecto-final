import { useState } from 'react';

const useCartStore = () => {
    const [carrito, setCarrito] = useState([]);
    // Lógica para manejar el estado del carrito

    return [carrito, setCarrito];
}

export default useCartStore;

