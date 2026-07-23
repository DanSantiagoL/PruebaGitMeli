import ProductCard from "./ProductCard";

function ProductGrid({ productos }) {
    return (
        <section id="servicios">
            <h2>Nuestros Servicios</h2>
            <div className="cards-grid">
                {productos.map((p, index) => (
                    <ProductCard
                        key={index}
                        nombre={p.nombre}
                        descripcion={p.descripcion}
                        precio={p.precio}
                    />
                ))}
            </div>
        </section>
    );
}
export default ProductGrid;