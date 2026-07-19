const select = document.getElementById("tipoFiltro");

const filtros = {
    aluno: document.getElementById("filtroAluno"),
    curso: document.getElementById("filtroCurso"),
    status: document.getElementById("filtroStatus"),
    tipo: document.getElementById("filtroTipo"),
    periodo: document.getElementById("filtroPeriodo")
};

function atualizarFiltro() {

    Object.values(filtros).forEach(div => {
        div.style.display = "none";
    });

    if (filtros[select.value]) {
        filtros[select.value].style.display = "block";
    }
}

select.addEventListener("change", atualizarFiltro);

window.addEventListener("load", () => {

    const params = new URLSearchParams(window.location.search);

    // Descobre qual filtro foi utilizado
    if (params.get("aluno")) {
        select.value = "aluno";
    } else if (params.get("curso")) {
        select.value = "curso";
    } else if (params.get("status")) {
        select.value = "status";
    } else if (params.get("tipoDocumento")) {
        select.value = "tipo";
    } else if (params.get("inicio") || params.get("fim")) {
        select.value = "periodo";
    } else {
        select.value = "";
    }

    atualizarFiltro();
});