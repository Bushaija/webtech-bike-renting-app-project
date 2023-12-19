import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { 
  Login, SignUp, BikesList, BikeDetails, BikeRental, PaymentForm, PaymentDetails, Home, NotFound
} from "./features";

import ImageUploadAndDelete from './features/ImageUploadAndDelete';

import AdminDashboard  from "./features/admin/AdminDashboard";

const App = () => {
  return (
    <section className="bg-[#fdfdfd] flex justify-center items-center">
      <BrowserRouter>
        
        <Routes>

        <Route path="/images" element={<ImageUploadAndDelete />} />
        <Route path="/admin" element={<AdminDashboard />} />

          {/* Enty point */}
          <Route path="/" element={<Home />} />
          {/* Authentication */}
          <Route path="/auth/login" element={<Login />} />
          <Route path="/auth/signup" element={<SignUp />} />

          {/* Bikes */}
          <Route path="/bikes" element={<BikesList />} />
          <Route path="/bikes/:id" element={<BikeDetails />} />

          {/* Rentals */}
          <Route path="/rentals/bikes/:id" element={<BikeRental />} />

          {/* Payments */}
          <Route path="/payments/:id" element={<PaymentForm />} />
          <Route path="/payments/:id" element={<PaymentDetails />} />

          {/* not found */}
          <Route path="*" element={<NotFound />} />
        </Routes>
      </BrowserRouter>
    </section>
  )
}

export default App