import React from "react";
import { Link } from "react-router-dom";

import { menus } from "./menus";

const SidemenuItems = () => {
  const renderMenus = () => {
    return menus.map((menu) => {
      return (
        <Link
          to={`admin/${menu.id}`}
          key={menu.id}
          className="w3-bar-item w3-button w3-padding"
        >
          <i className={menu.icon} />
          &nbsp; {menu.label}
        </Link>
      );
    });
  };
  return (
    <div>
      <div className="w3-container">
        <h5>Dashboard</h5>
      </div>
      <div className="w3-bar-block">
        <a
          href="#"
          className="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black"
          onclick="w3_close()"
          title="close menu"
        >
          <i className="fa fa-remove fa-fw" />
          &nbsp; Close Menu
        </a>
        {renderMenus()}
        <br />
        <br />
      </div>
    </div>
  );
};

export default SidemenuItems;
