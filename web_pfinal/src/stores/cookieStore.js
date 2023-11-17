import { useState } from 'react';

const useCookieStore = () => {
    const [galletas, setGalletas] = useState([]);
    // Lógica para manejar el estado de las galletas

    return [galletas, setGalletas];
}

export default useCookieStore;
