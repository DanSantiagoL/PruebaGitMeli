import Header from "./Header";
import Hero from "./Hero";
import ProductGrid from "./ProductGrid";
import Footer from "./Footer";
import { obtenerDisponibles } from "./catalogo";
import "./styles.css";

function App() {
    const productos = obtenerDisponibles();
    return (
        <>
            <Header />
            <main>
                <Hero />
                <ProductGrid productos={productos} />
            </main>
            <Footer />
        </>
    );
}
export default App;