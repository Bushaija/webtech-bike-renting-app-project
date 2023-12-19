import { homeBike } from "../assets";
import { H1Button, Title } from "../components";

const Home = () => {
  return (
    <section className="h-[100vh] max-w-[560px] flex flex-col justify-center gap-[70px]">
        <header className="">
            <Title 
                title="Ready to Ride!"
                fontSize={"28px"}
            />
            {/* <h1
                className="w-full text-center text-[1.8rem] font-semibold"
            >Ready to Ride!</h1> */}
        </header>
        <main className="">
            <main>
                <img 
                    src={homeBike} 
                    alt="background image" 
                    className="w-[370px]"
                />
            </main>
        </main>
        <footer className=" flex justify-center items-center">
            <H1Button 
                value={"Start Now"}
                link={"/auth/login"}
            />
        </footer>
    </section>
  )
}

export default Home