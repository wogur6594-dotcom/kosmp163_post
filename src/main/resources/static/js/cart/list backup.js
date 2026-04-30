const all = document.getElementById("all");
const ch = document.querySelectorAll(".ch")//document.getElementsByClassName("ch");
const del = document.getElementsByClassName("del");
const selectDel = document.getElementById("selectDel");
const list = document.getElementById("list")

getList();

function getList(){
    fetch("./cartlist")
    .then(r=>r.text())
    .then(r=>{
        r=r.trim()
        list.innerHTML=r;
    })
}

for (let d of del) {

    d.addEventListener("click", () => {
        let pn = d.previousElementSibling.getAttribute("data-pn")
        let p = new URLSearchParams();
        p.append("productNum", pn);

        fetch("./delete", {
            method: "POST",
            body: p
        })
            .then(r => r.text())
            .then(r => {
                r = r.trim();
                if (r > 0) {
                    d.parentElement.parentElement.remove();
                    location.reload()
                } else {
                    alert("실패")
                }
            })
    })
}

all.addEventListener("click", () => {
    ch.forEach((c) => {
        c.checked = all.checked;
    });
})

ch.forEach(c => {
    c.addEventListener("click", () => {
        let r = true;
        ch.forEach((e) => {
            if (!e.checked) {
                r = false;
            }
        })

        all.checked = r;

    })
})

selectDel.addEventListener("click", () => {
    let checked = document.querySelectorAll(".ch:checked");

    checked.forEach((c) => {
        let pn = c.getAttribute("data-pn");

        let p = new URLSearchParams();
        p.append("productNum", pn);

        fetch("./delete", {
            method: "POST",
            body: p
        })
            .then(r => r.text())
            .then(r => {
                r = r.trim();
                if (r > 0) {
                    c.parentElement.parentElement.remove();
                    location.reload()
                }
            })
    })
})