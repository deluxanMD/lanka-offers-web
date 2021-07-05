import React from "react";
import NavBar from "./NavBar";
import TopNav from "./TopNav";
import MidNav from "./MidNav";
import LastNav from "./LastNav/LastNav";

const MainNavigation = (props) => {
  return (
    <React.Fragment>
      <NavBar>
        <TopNav />
        <MidNav />
        <LastNav />
      </NavBar>
    </React.Fragment>
  );
};

export default MainNavigation;
