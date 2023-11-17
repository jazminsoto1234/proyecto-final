import React, { useState } from 'react';
import Home from '../pages/Home';
import Login from '../pages/Login';
import { Redirect, Route } from 'react-router-dom';

const AppRouter = () => {
  const [loggedIn, setLoggedIn] = useState(false);

  return (
    <>
      {loggedIn ? (
        <Redirect to="/home" />
      ) : (
        <>
          <Route path="/" exact component={Login} />
          <Route path="/home" component={Home} />
        </>
      )}
    </>
  );
};

export default AppRouter;
