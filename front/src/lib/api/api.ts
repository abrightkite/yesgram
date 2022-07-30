import axios, { AxiosError } from "axios";

export const apiorigin = "";

export const apiRoute = {
  gameBoard: "/game_board",
  gameRoom: "/room",
};

export function requestGet<T>(url: string, header: object) {
  return new Promise<T>((resolve, reject) => {
    axios
      .get(url, {
        headers: {
          "Content-Type": "application/json",
          ...header,
        },
      })
      .then((res) => {
        console.log(res);
        const returnVal = { ...res } as unknown;
        resolve(returnVal as T);
      })
      .catch((error: AxiosError) => {
        console.error(error.response?.data);
        console.error(error.response?.status);
        reject(error);
      });
  });
}

export function requestDelete<T>(url: string, header: object) {
  return new Promise<T>((resolve, reject) => {
    axios
      .delete(url, {
        headers: {
          "Content-Type": "application/json",
          ...header,
        },
      })
      .then((res) => {
        console.log(res);
        const returnVal = { ...res } as unknown;
        resolve(returnVal as T);
      })
      .catch((error: AxiosError) => {
        console.error(error.response?.data);
        console.error(error.response?.status);
        reject(error);
      });
  });
}

export function requestPost<T>(url: string, header: object, body: object) {
  return new Promise<T>((resolve, reject) => {
    axios
      .post(url, body, {
        headers: {
          "Content-Type": "application/json",
          ...header,
        },
      })
      .then((res) => {
        console.log(res);
        const returnVal = { ...res } as unknown;
        resolve(returnVal as T);
      })
      .catch((error: AxiosError) => {
        console.error(error.response?.data);
        console.error(error.response?.status);
        reject(error);
      });
  });
}

export function requestPut<T>(url: string, header: object, body: object) {
  return new Promise<T>((resolve, reject) => {
    axios
      .put(url, body, {
        headers: {
          "Content-Type": "application/json",
          ...header,
        },
      })
      .then((res) => {
        const returnVal = { ...res } as unknown;
        resolve(returnVal as T);
      })
      .catch((error: AxiosError) => {
        console.error(error.response?.data);
        console.error(error.response?.status);
        reject(error);
      });
  });
}
