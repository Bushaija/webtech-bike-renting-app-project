// src/api.js
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/';

const api = axios.create({
  baseURL: API_BASE_URL,
});

export const registerUser = async (userData) => {
  try {
    const response = await api.post('/users', userData);
    return response.data;
  } catch (error) {
    console.error('Error registering user:', error.message);
    throw error;
  }
};

export const loginUser = async (loginData) => {
    try {
      const response = await api.post('/auth/login', loginData);
      return response.data;
    } catch (error) {
      console.error('Error logging in:', error);
      throw error;
    }
  };

export const rentBike = async (rentalData) => {
  try {
    const response = await api.post('/reservations', rentalData);
    return response.data;
  } catch (error) {
    console.error('Error renting bike:', error);
    throw error;
  }
};

export const endRental = async (rentalId) => {
  try {
    const response = await api.put(`/reservations/${rentalId}/end`);
    return response.data;
  } catch (error) {
    console.error('Error ending rental:', error);
    throw error;
  }
};

export const processPayment = async (paymentData) => {
  try {
    const response = await api.post('/payments', paymentData);
    return response.data;
  } catch (error) {
    console.error('Error processing payment:', error);
    throw error;
  }
};

export const createStaions = async (stationData) => {
  try {
    const response = await api.post('/stations', stationData);
    return response.data;
  } catch (error) {
    console.error('Error creating stations:', error);
    throw error;
  }
};

export const listAllBikes = async () => {
  try {
    const response = await api.get('/bikes');
    return response.data;
  } catch (error) {
    console.error('Error listing all bikes:', error);
    throw error;
  }
};

export const getOneBike = async (bikeId) => {
  try {
    const response = await api.get(`/bikes/${bikeId}`);
    return response.data;
  } catch (error) {
    console.error(`Error getting bike with ID ${bikeId}:`, error);
    throw error;
  }
};
