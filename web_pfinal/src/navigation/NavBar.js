import React from 'react';
import { Link } from 'react-router-dom';

const NavBar = ({ loggedIn }) => {
    return (
        <nav>
            {loggedIn ? (
                <>
                    <Link to="/home">Home</Link>
                    <Link to="/order">Order</Link>
                </>
            ) : (
                <>
                    <Link to="/login">Login</Link>
                    <Link to="/register">Register</Link>
                </>
            )}
        </nav>
    );
}

export default NavBar;
