import { useState } from 'react';

const useOrderStore = () => {
    const [pedidos, setPedidos] = useState([]);
    // Lógica para manejar el estado de los pedidos

    return [pedidos, setPedidos];
}

export default useOrderStore;
