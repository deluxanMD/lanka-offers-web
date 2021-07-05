import React from "react";
import "./Home.css";

import MainContent from "../components/MainContent";
import SectionPick from "../components/SectionPick";
import SectionBrand from "../components/SectionBrand";
import SectionSuperOffers from "../components/SectionSuperOffers";
import SectionPopular from "../components/SectionPopular";
import SectionLatest from "../components/SectionLatest";
import SectionHotDeals from "../components/SectionHotDeals";
import SectionTopSlider from "../components/SectionTopSlider";

import { TOPSLIDER } from "../../shared/constants/top-slider";
import { MAINDEALS } from "../../shared/constants/main-deals";
import { BRANDS } from "../../shared/constants/brands";
import { SUPERPICKS } from "../../shared/constants/super-picks";
import { PRODUCTS } from "../../shared/constants/products";

const Home = () => {
  return (
    <React.Fragment>
      <MainContent>
        <SectionTopSlider items={TOPSLIDER} />
        <SectionHotDeals items={MAINDEALS} />
        <SectionPick items={SUPERPICKS} />
        <SectionBrand items={BRANDS} />
        <SectionPopular items={PRODUCTS} />
        <SectionLatest items={PRODUCTS} />
        <SectionSuperOffers items={PRODUCTS} />
      </MainContent>
    </React.Fragment>
  );
};
export default Home;
