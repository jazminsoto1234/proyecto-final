import { useState } from 'react';

const useUserStore = () => {
    const [user, setUser] = useState({});
    // Lógica para manejar el estado del usuario

    return [user, setUser];
}

export default useUserStore;
