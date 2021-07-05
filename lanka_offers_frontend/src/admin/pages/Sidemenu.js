import React from "react";
import lanka from "../../assets/images/logo/lanka.jpeg";

import SidemenuItems from "./SidemenuItems";

const Sidemenu = () => {
  return (
    <nav
      className="w3-sidebar w3-collapse w3-white w3-animate-left"
      style={{ zIndex: 3, width: "300px" }}
      id="mySidebar"
    >
      <br />
      <div className="w3-container w3-row">
        <div className="w3-col s4">
          <img
            src={lanka}
            className="w3-circle w3-margin-right"
            style={{ width: "46px" }}
          />
        </div>
        <div className="w3-col s8 w3-bar">
          <span>
            Welcome, <strong>Mike</strong>
          </span>
          <br />
          <a href="#" className="w3-bar-item w3-button">
            <i className="fa fa-envelope" />
          </a>
          <a href="#" className="w3-bar-item w3-button">
            <i className="fa fa-user" />
          </a>
          <a href="#" className="w3-bar-item w3-button">
            <i className="fa fa-cog" />
          </a>
        </div>
      </div>
      <hr />
      <SidemenuItems />
    </nav>
  );
};

export default Sidemenu;
