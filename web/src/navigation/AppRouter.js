import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import NavBar from './NavBar';
import Home from '../pages/Home';
import Login from '../pages/Login';
import Register from '../pages/Register';
import OrderPage from '../pages/OrderPage';

const AppRouter = () => {
    return (
        <Router>
            <NavBar />
            <Switch>
                <Route path="/" exact component={Home} />
                <Route path="/login" component={Login} />
                <Route path="/register" component={Register} />
                <Route path="/pedido" component={OrderPage} />
            </Switch>
        </Router>
    );
}

export default AppRouter;
