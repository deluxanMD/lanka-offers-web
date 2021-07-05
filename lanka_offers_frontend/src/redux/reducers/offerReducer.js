import {
  OFFERS,
  BRANDS,
  lastNavList,
  lastNavSubmenu,
  CITIES,
  TOWNS,
} from "../../shared/constants";

const initial_state = {
  offers: OFFERS,
  brands: BRANDS,
  categories: lastNavList,
  subCategories: lastNavSubmenu,
  mainLocations: CITIES,
  subLocations: TOWNS,
};

const offerReducer = (state = initial_state, { type, payload }) => {
  switch (type) {
    default:
      return state;
  }
};

export default offerReducer;
