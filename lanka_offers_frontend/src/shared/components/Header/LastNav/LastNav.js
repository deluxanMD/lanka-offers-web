import React from "react";
import "./LastNav.css";
import LastNavList from "./LastNavList";

const LastNav = () => {
  return (
    <div>
      <div id="lastnav" className="lastnav  w3-row w3-hide-small">
        <LastNavList />
      </div>
    </div>
  );
};

export default LastNav;
