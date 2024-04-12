window.addEventListener("load", solve);

window.addEventListener("load", solve);

function solve() {
  const scholarshipState = {
    studentName: null,
    university: null,
    score: null,
  };
 
  const inputDOMSelectors = {
    studentName: document.getElementById("student"),
    university: document.getElementById("university"),
    score: document.getElementById("score"),
  };
 
  const otherDOMSelectors = {
    nextBtn: document.getElementById("next-btn"),
    previewList: document.getElementById("preview-list"),
  };
 
  otherDOMSelectors.nextBtn.addEventListener("click", nextBtnHandler);
 
  function nextBtnHandler() {
    if (
      inputDOMSelectors.studentName.value === "" ||
      inputDOMSelectors.university.value === "" ||
      inputDOMSelectors.score.value === ""
    ) {
      return;
    }
 
    const li = createElement("li", otherDOMSelectors.previewList, null, [
      "application",
    ]);
    const article = createElement("article", li);
    createElement("h4", article, inputDOMSelectors.studentName.value);
    createElement(
      "p",
      article,
      `University: ${inputDOMSelectors.university.value}`
    );
    createElement("p", article, `Score: ${inputDOMSelectors.score.value}`);
 
    const editBtn = createElement(
      "button",
      li,
      "edit",
      ["action-btn"],
      null,
      null,
      false
    );
    const applyBtn = createElement(
      "button",
      li,
      "apply",
      ["action-btn"],
      null,
      null,
      false
    );
 
    editBtn.addEventListener("click", () => editBtnHandler(li));
    applyBtn.addEventListener("click", () => applyBtnHandler(li));
 
    scholarshipState.studentName = inputDOMSelectors.studentName.value;
    scholarshipState.university = inputDOMSelectors.university.value;
    scholarshipState.score = inputDOMSelectors.score.value;
 
    otherDOMSelectors.nextBtn.disabled = true;
    inputDOMSelectors.studentName.value = "";
    inputDOMSelectors.university.value = "";
    inputDOMSelectors.score.value = "";
  }
 
  function editBtnHandler(li) {
    otherDOMSelectors.nextBtn.disabled = false;
    inputDOMSelectors.studentName.value = scholarshipState.studentName;
    inputDOMSelectors.university.value = scholarshipState.university;
    inputDOMSelectors.score.value = scholarshipState.score;
 
    otherDOMSelectors.previewList.removeChild(li);
  }
 
  function applyBtnHandler(li) {
    otherDOMSelectors.nextBtn.disabled = false;
    li.removeChild(li.querySelector(".action-btn")); // Remove the [Edit] button
    li.removeChild(li.querySelector(".action-btn")); // Remove the [Apply] button
    document.getElementById("candidates-list").appendChild(li);
  }
 
  function createElement(
    type,
    parentNode,
    content,
    classes,
    id,
    attributes,
    useInnerHtml
  ) {
    const htmlElement = document.createElement(type);
 
    if (content && useInnerHtml) {
      htmlElement.innerHTML = content;
    } else {
      if (content && type !== "input") {
        htmlElement.textContent = content;
      }
 
      if (content && type === "input") {
        htmlElement.value = content;
      }
    }
 
    if (classes && classes.length > 0) {
      htmlElement.classList.add(...classes);
    }
 
    if (id) {
      htmlElement.id = id;
    }
 
    if (attributes) {
      for (const key in attributes) {
        htmlElement.setAttribute(key, attributes[key]);
      }
    }
 
    if (parentNode) {
      parentNode.appendChild(htmlElement);
    }
 
    return htmlElement;
  }
}