import React from "react";
import "./Offers.css";
import { useSelector } from "react-redux";

import SectionTopSlider from "../../components/SectionTopSlider";
import { TOPSLIDER } from "../../../shared/constants";

import Search from "./Search";
import Filters from "./Filters";
import AllOffers from "./AllOffers";

const ViewOffers = () => {
  const offer = useSelector((state) => state.offer);
  const { categories, subCategories, mainLocations, subLocations } = offer;

  return (
    <section
      className="w3-row w3-center w3-margin w3-content"
      style={{ maxWidth: "100%" }}
    >
      <div className="spacer"></div>
      <div>
        <SectionTopSlider items={TOPSLIDER} />
        <Search />
        <section className="w12-row filter-section">
          <div className="w3-col s12 m12 l2 brands-filters">
            <Filters
              title="Categories"
              mainList={categories}
              subList={subCategories}
            />
            <hr />
            <Filters
              title="Locations"
              mainList={mainLocations}
              subList={subLocations}
            />
          </div>
          <div className="w3-col s12 m12 l10">
            <AllOffers />
          </div>
        </section>
      </div>
    </section>
  );
};

export default ViewOffers;
