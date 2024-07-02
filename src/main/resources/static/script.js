async function uploadFile() {
	let formData = new FormData();
	formData.append('data', fileupload.files[0]);
	await fetch('http://localhost:8080/photoz', {
		mode: 'no-cors',
		method: 'POST',
		body: formData,
	})
		.then((result) => result.text())
		.then((text) => alert(text));
}

function previewImage(event) {
	const preview = document.getElementById('image-preview');
	const file = event.target.files[0];

	if (file) {
		const reader = new FileReader();

		reader.onload = function () {
			const img = document.createElement('img');
			img.id = 'preview-img';
			img.src = reader.result;
			img.alt = 'Image Preview';
			img.style.maxWidth = '100%';
			img.style.maxHeight = '100%';

			while (preview.firstChild) {
				preview.removeChild(preview.firstChild);
			}

			preview.appendChild(img);

			const closeIcon = createCloseIcon();
			preview.appendChild(closeIcon);
		};

		reader.readAsDataURL(file);
	} else {
		clearImagePreview();
	}
}

function clearImagePreview() {
	const preview = document.getElementById('image-preview');

	while (preview.firstChild) {
		preview.removeChild(preview.firstChild);
	}
}

function createCloseIcon() {
	const closeIcon = document.createElement('i');
	closeIcon.className = 'fa-solid fa-xmark close-icon';
	closeIcon.style.position = 'absolute';
	closeIcon.style.top = '5px';
	closeIcon.style.right = '5px';
	closeIcon.style.cursor = 'pointer';
	closeIcon.style.fontSize = '1.5rem';
	closeIcon.style.color = '#ffffff';
	closeIcon.style.backgroundColor = 'rgba(0, 0, 0, 0.5)';
	closeIcon.style.padding = '5px';
	closeIcon.style.borderRadius = '50%';

	closeIcon.addEventListener('click', clearImagePreview);

	return closeIcon;
}
