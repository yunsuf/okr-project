import axios from 'axios';

const API_URL = 'http://localhost:8080/api/okr';

const api = axios.create({
    baseURL: API_URL,
});

export const getObjectives = () => api.get('/');
export const createObjective = (userId, objective) => api.post(`/user/${userId}`, objective);
export const updateObjective = (id, objective) => api.put(`/${id}`, objective);
export const deleteObjective = (id) => api.delete(`/${id}`);
export const addKeyResult = (id, keyResult) => api.post(`/${id}/keyresult`, keyResult);

// AI Endpoints
export const evaluateOkrs = (objectives) => api.post('/ai/evaluate', objectives);
export const chatWithOkrs = (objectives, question) => api.post('/ai/chat', { objectives, question });
export const generateOkr = (prompt) => api.post('/ai/generate', prompt);

export default api;
