import React, { useState } from "react";
import { Link } from "react-router-dom";
import Dropdown from "rc-dropdown";
import Menu, { Item as MenuItem, Divider } from "rc-menu";
import "rc-dropdown/assets/index.css";

import { lastNavList } from "../../../constants/last-nav-list";
import { lastNavSubmenu } from "../../../constants/last-nav-submenu";

const LastNavList = () => {
  const [selectedMenu, setSelectedMenu] = useState(0);

  const onMouseOver = (nav) => setSelectedMenu(nav.id);

  const onVisibleChange = (visible) => {};

  const renderSubMenu = () => {
    return lastNavSubmenu.map((menu) => {
      return (
        menu.category_id === selectedMenu && (
          <>
            <MenuItem key={menu.id}>{menu.name}</MenuItem>
            <Divider />
          </>
        )
      );
    });
  };

  const menu = <Menu>{renderSubMenu()}</Menu>;

  const renderNavList = () => {
    return lastNavList.map((nav) => {
      return (
        <Dropdown
          key={nav.id}
          trigger={["hover"]}
          overlay={menu}
          animation="slide-up"
          onVisibleChange={onVisibleChange}
        >
          <div
            style={{ display: "inline" }}
            onMouseOver={() => onMouseOver(nav)}
          >
            <Link
              to={nav.to}
              className="w3-col  s3 m2 l1 w3-hover-opacity noti"
            >
              <i className={nav.icon} />
              <br />
              {nav.name}
              <span class="badge">
                <strong className="notification">{nav.notification}</strong>
              </span>
            </Link>
          </div>
        </Dropdown>
      );
    });
  };
  return <>{renderNavList()}</>;
};

export default LastNavList;
