function addNewArtist() {
    let name = $('#name').val();
    let dob = $('#dob').val();
    let job = $('#job').val();
    let img = $('#images')[0].files[0];
    let fd = new FormData();
    fd.append("file", img);
    let newArtist = {
        name: name,
        dob: dob,
        job: {id: job}
    };
    fd.append("newArtist", JSON.stringify(newArtist));
    $.ajax({
        url: "http://localhost:8080/api/artists",
        contentType: false, // NEEDED, DON'T OMIT THIS (requires jQuery 1.6+)
        processData: false,
        headers: {'Content-Type': undefined},
        type: "POST",
        data: fd,
        success: successHandler
    });
    event.preventDefault();
}

function updateArtist() {
    let id = $('#id').val();
    let name = $('#name1').val();
    let dob = $('#dob1').val();
    let img = $('#images')[0].files[0];
    let fd = new FormData();
    fd.append("file", img);
    let newArtist = {
        id: id,
        name: name,
        dob: dob,
        image: img,
        job: {id: job}
    };
    fd.append("newArtist", JSON.stringify(newArtist));
    $.ajax({
        url: "http://localhost:8080/api/artists/" + id,
        contentType: false, // NEEDED, DON'T OMIT THIS (requires jQuery 1.6+)
        processData: false,
        headers: {'Content-Type': undefined},
        type: "PUT",
        data: fd,
        success: successHandler
    });
    event.preventDefault();
}

function getArtist(artist) {
    return `<tr>` +
        `<td><img width="100" height="100" src="../img/${artist.image}" crossOrigin="anonymous"></td>` +
        `<td>${artist.name}</td>` +
        `<td>${artist.dob}</td>` +
        `<td>${artist.job?.name}</td>` +
        `<td><button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#editForm" value="${artist.id}" onclick="showFormEdit(this)">Edit</button></td>` +
        `<td><button class="btn btn-primary" value="${artist.id}" onclick="deleteArtist(this)">Delete</button></td>` +
        `</tr>`;
}

function successHandler() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/artists/list",
        success: function (data) {
            let content =
                `<tr>` +
                `<th>Ảnh đại diện</th>` +
                `<th>Tên nghệ sĩ</th>` +
                `<th>Ngày sinh</th>` +
                `<th>Nghề nghiệp</th>` +
                `<th>Edit</th>` +
                `<th>Delete</th>` +
                `</tr>`
            for (let i = 0; i < data.length; i++) {
                content += getArtist(data[i]);
            }
            document.getElementById('artistList').innerHTML = content;
        }
    });
    event.preventDefault();
}

function findAllJobs() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/jobs/list",
        success: function (data) {
            let jobs = data;
            let content = "";
            for (let i = 0; i < jobs.length; i++) {
                content += `<option value="${data[i].id}">${data[i].name}</option>`
            }
            document.getElementById('job').innerHTML = content;
        }
    });
}

function showFormEdit(e) {
    let id = e.getAttribute("value");
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/artists/" + id,
        success: function (data) {
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/api/jobs/list",
                success: function (data) {
                    let jobs = data;
                    let content = "";
                    for (let i = 0; i < jobs.length; i++) {
                        content += `<option value="${data[i].id}">${data[i].name}</option>`
                    }
                    document.getElementById('job1').innerHTML = content;
                }
            });
            let content =
                `
            <form id="editArtist" enctype="multipart/form-data">
                <div class="modal-body">
                    <input id="id" type="hidden" value="${id}">
                    <div class="mb-3">
                        <label class="form-label">Tên</label>
                        <input type="text" class="form-control" id="name1" value="${data.name}">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Ngày sinh</label>
                        <input type="date" class="form-control" id="dob1" value="${data.dob}">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Nghề nghiệp</label>
                        <select class="form-select" id="job1">
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Ảnh đại diện</label>
                        <input type="file" id="images1" name="images">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="updateArtist()">Save changes</button>
                </div>
            </form>
                `
            document.getElementById("editFormBody").innerHTML = content;
        }
    })
}

function deleteArtist(e) {
    let id = e.getAttribute("value");
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/artists/" + id,
        success: function () {
            alert("OK")
        }
    });
    event.preventDefault();
}

findAllJobs();
successHandler()