import { BRAND_TYPES } from "../types/brandTypes";

export const expandMainMenu = (list) => ({
  type: BRAND_TYPES.EXPAND_MAIN_MENU,
  payload: list.id,
});

export const handleMainMenu = (list) => ({
  type: BRAND_TYPES.CHECK_MAIN_MENU,
  payload: list.id,
});

export const handleSubMenu = (list) => ({
  type: BRAND_TYPES.CHECK_SUB_MENU,
  payload: list.id,
});

export const handleMainCity = (list) => ({
  type: BRAND_TYPES.CHECK_MAIN_CITY,
  payload: list.id,
});

export const handleSubCity = (list) => ({
  type: BRAND_TYPES.CHECK_SUB_CITY,
  payload: list.id,
});

export const handleBrand = (list) => ({
  type: BRAND_TYPES.CHECK_MAIN_CITY,
  payload: list.id,
});
