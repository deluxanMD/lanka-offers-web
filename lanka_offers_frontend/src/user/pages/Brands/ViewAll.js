import React from "react";
import "./Brands.css";
import { useSelector } from "react-redux";

import SectionTopSlider from "../../components/SectionTopSlider";

import Search from "./Search";
import Filters from "./Filters";
import AllBrands from "./AllBrands";

import { TOPSLIDER } from "../../../shared/constants";

const ViewAll = () => {
  const brand = useSelector((state) => state.brand);
  const { brands, main_category, sub_category, main_city, sub_city, expanded } =
    brand;

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
              title="Category"
              mainList={main_category}
              subList={sub_category}
            />
            <hr />
            <Filters title="Location" mainList={main_city} subList={sub_city} />
            <hr />
            <Filters
              title="Brand"
              mainList={main_category}
              subList={sub_category}
            />
          </div>
          <div className="w3-col s12 m12 l10">
            <AllBrands />
          </div>
        </section>
      </div>
    </section>
  );
};

export default ViewAll;
