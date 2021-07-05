import React from "react";
import './NavBar.css';


const NavBar = (props) => {
  return <section className="topheader">{props.children}</section>;
};

export default NavBar;
