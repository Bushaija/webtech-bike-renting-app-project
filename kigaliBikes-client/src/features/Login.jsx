import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Title, H2Title, Input, H1Button, TextLink } from "../components";
import { loginUser } from "../api/api.js";
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const Login = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [loading, setLoading] = useState(false);

  const navigate = useNavigate();

  const handleEmailChange = (event) => {
    setEmail(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleLoginIn = async (event) => {
    event.preventDefault(); // Prevents the form from submitting the traditional way

    try {

      setLoading(true);

      const loginData = {
        email: email,
        passwordHash: password,
      };

      const userData = await loginUser(loginData);

      if (userData) {
        toast.success("Login successful!");
        navigate("/bikes");
      }

      console.log("Login successful:", userData);
    } catch (error) {
      toast.error("Invalid email or password. Please try again.");
      console.error("Error logging in:", error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <section className="h-[100vh] max-w-[560px]  flex flex-col justify-center items-center gap-[60px]">

      <header className="border-t-2 border-b-2 border-black max-w-[200px]">
        <Title 
          title={"Kigali Bikes"}
          fontSize={"28px"}
        />
      </header>

      <div className="flex justify-center items-center text-[1rem] font-semibold">
        {loading && <p>Loading...</p>}
      </div>

      <form onSubmit={(e) => handleLoginIn(e)} className="w-full flex flex-col items-center justify-center gap-4">
        <H2Title 
          title={"Login"}
        />

        <Input
          placeholder={"Email"}
          value={email}
          onChange={handleEmailChange}
        />

        <Input
          placeholder={"Password"}
          value={password}
          type={"password"} 
          onChange={handlePasswordChange}
        />

        <div className="flex flex-col items-center justify-center gap-2 mt-8">
          <H1Button value={"Login"} />  
          <TextLink 
            paragraph={"Don't have an account?"}
            link={"/auth/signup"}
            value={"Sign up"}
          />       
        </div>
      </form>
      {/* Toast container for notifications */}
      <div className="flex justify-center items-center">
        <ToastContainer />
      </div>
    </section>
  )
}

export default Login;
