function attachGradientEvents() {
    const element = document.querySelector('#gradient');
    const result = document.querySelector('#result');

    element.addEventListener('mousemove', move);
    element.addEventListener('mouseout', out);

    function move (e) {
        let power = e.offsetX / (e.target.clientWidth - 1);

        power = Math.trunc(power * 100);
        result.textContent = power + '%';
    }

    function out(e) {
        result.textContent = '';
    }
}