import React from "react";
import { useSelector, useDispatch } from "react-redux";

import {
  expandMainMenu,
  handleMainMenu,
  handleSubMenu,
  handleMainCity,
  handleSubCity,
} from "../../../redux/actions/brandActions";

const Filters = (props) => {
  const { title, mainList, subList } = props;

  const dispatch = useDispatch();
  const brand = useSelector((state) => state.brand);
  const { brands, expanded } = brand;

  const handleExpand = (list) => dispatch(expandMainMenu(list));

  const handleMain = (list) => {
    if (title === "Category") {
      return dispatch(handleMainMenu(list));
    } else if (title === "Location") {
      return dispatch(handleMainCity(list));
    } else if (title === "Brand") {
      return dispatch(handleMainMenu(list));
    }
  };

  const handleSub = (list) => {
    if (title === "Category") {
      return dispatch(handleSubMenu(list));
    } else if (title === "Location") {
      return dispatch(handleSubCity(list));
    } else if (title === "Brand") {
      return dispatch(handleMainMenu(list));
    }
  };

  const renderMainList = () => {
    return mainList.map((list) => {
      return (
        <div key={list.id} className="filter-list">
          <i
            className={`fa fas fa-caret-${
              list.id === expanded ? "down" : "right"
            } filter-list-icon`}
            onClick={() => handleExpand(list)}
          />
          <div className="filter-list-item">
            <input
              type="checkbox"
              id="main-category"
              name="main-category"
              value={list.name}
              checked={list.checked}
              onChange={() => handleMain(list)}
              style={{ cursor: "pointer" }}
            />
            <label for="main-category" className="filter-list-label">
              {list.name}
            </label>
            {subList.map((innerList) => {
              return (
                innerList.category_id === expanded &&
                innerList.category_id === list.id && (
                  <div key={innerList.id} className="sub-category">
                    <input
                      type="checkbox"
                      id="sub-category"
                      name="sub-category"
                      value={innerList.name}
                      checked={innerList.checked}
                      onChange={() => handleSub(innerList)}
                      style={{ cursor: "pointer" }}
                    />
                    <label for="sub-category" className="sub-list-label">
                      {innerList.name}
                    </label>
                  </div>
                )
              );
            })}
          </div>
        </div>
      );
    });
  };

  return (
    <div className="brands-filters">
      <p className="filter-title">{title}</p>
      <hr />
      {renderMainList()}
    </div>
  );
};

export default Filters;
