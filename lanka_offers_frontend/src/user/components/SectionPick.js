import React, { Component } from "react";
import './SectionPick.css';

import SuperPick from "./CoreComponents/SuperPick";

const SectionPick = (props) => {
  if (props.items.length === 0) {
    return (
      <div className="w3-center">
        <h2>No Super Pics Found</h2>
      </div>
    );
  }

  return (
    <React.Fragment>
      <section className="w3-row-padding ">
        <h6 className="w3-col s8 m6 l6 w3-left-align">Popular Pic for you</h6>
        <h6 className="w3-col s4 m6 l6  w3-right-align view">View All</h6>

        {props.items.map((superpick) => (
          <SuperPick
            key={superpick.id}
            id={superpick.id}
            image={superpick.image}
            name={superpick.name}
          />
        ))}
      </section>
    </React.Fragment>
  );
};

export default SectionPick;
