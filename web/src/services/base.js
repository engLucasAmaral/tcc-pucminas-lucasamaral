export const URL_BASE_AMBIENTE = 'http://tccpmbd.tech/pmbd/api/v1/pessoas'
// export const URL_BASE_AMBIENTE = 'http://localhost:8080/pmbd/api/v1/pessoas'
export const TOKEN_KEY = "TOKEN_PMBD";
export const isAuthenticated = () => localStorage.getItem(TOKEN_KEY) !== null;
export const isAuthenticatedVisitante = () => localStorage.getItem(TOKEN_KEY) !== null && localStorage.getItem(TOKEN_KEY) === 'VISITANTE';
export const getToken = () => localStorage.getItem(TOKEN_KEY);
export const login = token => {
    localStorage.setItem(TOKEN_KEY, token);
};
export const logout = () => {
    localStorage.removeItem(TOKEN_KEY);
};
