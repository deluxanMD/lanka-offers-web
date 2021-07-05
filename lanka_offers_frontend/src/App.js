import React, { useState, useCallback } from "react";
import {
  BrowserRouter as Router,
  Route,
  Redirect,
  Switch,
} from "react-router-dom";
import MainNavigation from "./shared/components/Header/MainNavigation";
import MainFooter from "./shared/components/Footer/MainFooter";
import Home from "./user/pages/Home";
import Dashboard from "./admin/pages/Dashboard";
import { AuthContext } from "./shared/context/auth-context";
import ViewAll from "./user/pages/Brands/ViewAll";
import ViewOffers from "./user/pages/Offers/ViewOffers";
import SingleOffer from "./user/pages/Offers/SingleOffer";

import Categories from "./admin/pages/Categories";

function App(props) {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const login = useCallback(() => {
    setIsLoggedIn(true);
  }, []);

  const logout = useCallback(() => {
    setIsLoggedIn(false);
  }, []);

  return (
    <AuthContext.Provider
      value={{ isLoggedIn: isLoggedIn, login: login, logout: logout }}
    >
      <Router>
        <MainNavigation />
        <main>
          <Switch>
            <Route path="/" exact>
              <Home />
            </Route>
            <Route path="/admin" exact>
              <Dashboard />
            </Route>
            <Route path="/brands" exact>
              <ViewAll />
            </Route>
            <Route path="/offers" exact>
              <ViewOffers />
            </Route>
            <Route path="/offers/:id" exact>
              <SingleOffer />
            </Route>
            {/* admin section */}
            <Route path="/admin/categories">
              <Categories />
            </Route>
            <Redirect to="/" />
          </Switch>
        </main>
        <MainFooter />
      </Router>
    </AuthContext.Provider>
  );
}

export default App;
