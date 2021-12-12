function addNewArtist() {
    // let formData = new FormData();
    let name = $('#name').val();
    let dob = $('#dob').val();
    let countryside = $('#countryside').val();
    let fanpage = $('#fanpage').val();
    let job = $('#job').val();
    let image = $('#images').val();
    // formData.append('image', file);
    let newArtist = {
        name: name,
        dob: dob,
        countryside: countryside,
        fanpage: fanpage,
        file: image,
        job: {
            id: job
        }
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newArtist),
        url: "/api/artists",
        success: successHandler
    });
    $('#exampleModal').modal('hide');
    event.preventDefault();
}

function searchByJob() {
    let idJob = $('#searchByJob').val();
    $.ajax({
        type: "GET",
        url: "/api/artists/job/" + idJob,
        success: function (data) {
            let content = '<thead>' +
                '    <tr>\n' +
                '        <th>Ảnh đại diện</th>\n' +
                '        <th>Tên nghệ sĩ</th>\n' +
                '        <th>Ngày sinh</th>\n' +
                '        <th>Quê quán</th>\n' +
                '        <th>Fanpage</th>\n' +
                '        <th>Nghề nghiệp</th>\n' +
                '        <td>Delete</td>\n' +
                '        <td>Edit</td>\n' +
                '    </tr>' +
                '   </thead>';
            for (let i = 0; i < data.length; i++) {
                content += getArtist(data[i]);
            }
            document.getElementById('artistList').innerHTML = content;
        }
    });
}

function getArtist(artist) {
    return `<tr>` +
        `<td><img width="100" height="100" src="/image/${artist.image}"></td>` +
        `<td> ${artist.name}</td>` +
        `<td>${artist.dob}</td>` +
        `<td>${artist.countryside}</td>` +
        `<td>${artist.fanpage}</td>` +
        `<td>${artist.job?.name}</td>` +
        `<td><button value="${artist.id}" onclick="showFormEdit(this)">Edit</button></td>` +
        `<td><button value="${artist.id}" onclick="deleteArtist(this)">Delete</button></td>` +
        `</tr>`;
}

function successHandler() {
    $.ajax({
        type: "GET",
        //tên API
        url: "/api/artists",
        //xử lý khi thành công
        success: function (data) {
            // hien thi danh sach o day
            let content =
                '    <tr>\n' +
                '        <th>Ảnh đại diện</th>\n' +
                '        <th>Tên nghệ sĩ</th>\n' +
                '        <th>Ngày sinh</th>\n' +
                '        <th>Quê quán</th>\n' +
                '        <th>Fanpage</th>\n' +
                '        <th>Nghề nghiệp</th>\n' +
                '        <td>Delete</td>\n' +
                '        <td>Edit</td>\n' +
                '    </tr>';
            for (let i = 0; i < data.length; i++) {
                content += getArtist(data[i]);
            }
            document.getElementById('body-list').innerHTML = content;
        }

    });
    event.preventDefault();
}

function showFormCreate() {
    $(document).ready(function () {
        let content = `
            <form id="addArtist" enctype="multipart/form-data">
                    <div class="modal-body">
                        <div class="mb-3">
                            <label class="form-label">Tên</label>
                            <input type="text" class="form-control" id="name">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Ngày sinh</label>
                            <input type="date" class="form-control" id="dob">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Quê quán</label>
                            <input type="text" class="form-control" id="countryside">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Fanpage</label>
                            <input type="text" class="form-control" id="fanpage">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Nghề nghiệp</label>
                            <select class="form-select" id="job">
                                <option selected disabled value="">Choose...</option>
                                <option th:each="j : ${jobs}" th:value="${j.id}" th:text="${j.name}"></option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Ảnh đại diện</label>
                            <input type="file" id="file">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" onclick="addNewArtist()">Save changes</button>
                    </div>
                </form>
        `
        document.getElementById('createForm').innerHTML = content;
    })
}