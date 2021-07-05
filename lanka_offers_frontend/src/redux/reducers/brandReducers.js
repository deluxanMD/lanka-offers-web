import {
  BRANDS,
  lastNavList,
  lastNavSubmenu,
  CITIES,
  TOWNS,
} from "../../shared/constants";
import { BRAND_TYPES } from "../types/brandTypes";

const initial_state = {
  brands: BRANDS,
  main_category: lastNavList,
  sub_category: lastNavSubmenu,
  main_city: CITIES,
  sub_city: TOWNS,
  expanded: 0,
};

const brandReducer = (state = initial_state, { type, payload }) => {
  switch (type) {
    case BRAND_TYPES.EXPAND_MAIN_MENU:
      return {
        ...state,
        expanded: state.expanded === payload ? 0 : payload,
      };

    case BRAND_TYPES.CHECK_MAIN_MENU:
      const index = state.main_category.findIndex(
        (category) => category.id === payload
      );

      const newMain = [...state.main_category];

      newMain[index].checked = !state.main_category[index].checked;

      return {
        ...state,
        selected: {
          ...state.selected,
        },
        main_category: newMain,
        sub_category: [
          ...state.sub_category,
          state.sub_category.map((sub) => {
            if (sub.category_id === payload) {
              if (state.main_category[index].checked === false) {
                return (sub.checked = false);
              } else {
                return (sub.checked = true);
              }
            }
          }),
        ],
      };

    case BRAND_TYPES.CHECK_SUB_MENU:
      const i = state.sub_category.findIndex(
        (category) => category.id === payload
      );

      const newSub = [...state.sub_category];

      newSub[i].checked = !state.sub_category[i].checked;

      return { ...state, sub_category: newSub };

    case BRAND_TYPES.CHECK_MAIN_CITY:
      const cityIndex = state.main_city.findIndex(
        (category) => category.id === payload
      );

      const newCity = [...state.main_city];

      newCity[cityIndex].checked = !state.main_city[cityIndex].checked;

      return {
        ...state,
        selected: {
          ...state.selected,
        },
        main_city: newCity,
        sub_city: [
          ...state.sub_city,
          state.sub_city.map((sub) => {
            if (sub.category_id === payload) {
              if (state.main_city[cityIndex].checked === false) {
                return (sub.checked = false);
              } else {
                return (sub.checked = true);
              }
            }
          }),
        ],
      };

    case BRAND_TYPES.CHECK_SUB_CITY:
      const subCityIndex = state.sub_city.findIndex(
        (category) => category.id === payload
      );

      const newSubCity = [...state.sub_city];

      newSubCity[subCityIndex].checked = !state.sub_city[subCityIndex].checked;

      return { ...state, sub_city: newSubCity };

    default:
      return state;
  }
};

export default brandReducer;
