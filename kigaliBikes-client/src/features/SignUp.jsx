import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { Title, H2Title, Input, Button, TextLink } from "../components";
import { registerUser } from "../api/api.js";
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const SignUp = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  const handleNameChange = (event) => {
    setName(event.target.value);
  };

  const handleEmailChange = (event) => {
    setEmail(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleSignUp = async (event) => {
    event.preventDefault();
    console.log("userData")
    try {
      setLoading(true);

      const userData = {
        username: name,
        passwordHash: password,
        email: email,
        role: 0,
      };

      const newUser = await registerUser(userData);

      if(newUser) {
        toast.success("User registered successfully!");
        navigate("/auth/login");
      }
      console.log("User registered successfully:", newUser);
    } catch (error) {
      toast.error("Error registering user. Please try again.");
      console.error("Error registering user:", error);
    } finally {
      setLoading(false);
    }
  };

  return (
    <section className="h-[100vh] max-w-[560px]  flex flex-col justify-center items-center gap-[60px]">
      <header className="border-t-2 border-b-2 border-black max-w-[200px]">
        <Title title={"Kigali Bikes"} />
      </header>

      <div className="flex justify-center items-center text-[1rem] font-semibold">
      {loading && <p>Loading...</p>}
      </div>

      <form onSubmit={(e) => handleSignUp(e)} className="w-full flex flex-col items-center justify-center gap-4">
        <H2Title title={"Sign Up"} />

        <Input
          placeholder={"Username"}
          value={name}
          onChange={handleNameChange}
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
        
        <Button value={"Sign up"} />
        
        <TextLink
          paragraph={"Already have an account?"}
          value={"Login"}
          link={"/auth/login"}
        />

      </div>
      </form>

      {/* Toast container for notifications */}
      <div className="flex justify-center items-center">
        <ToastContainer />
      </div>
    </section>
  );
}

export default SignUp;
