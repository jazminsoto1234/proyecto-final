import { useState } from 'react';

const useAddressStore = () => {
    const [direccion, setDireccion] = useState({});
    // Lógica para manejar el estado de la dirección

    return [direccion, setDireccion];
}

export default useAddressStore;
