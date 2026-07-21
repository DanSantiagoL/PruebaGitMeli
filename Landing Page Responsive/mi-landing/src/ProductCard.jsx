function ProductCard({ nombre, descripcion, precio }) {
    return (
        <div className="card">
            <h3>{nombre}</h3>
            <p>{descripcion}</p>
            <span>{precio}</span>
        </div>
    );
}
export default ProductCard;