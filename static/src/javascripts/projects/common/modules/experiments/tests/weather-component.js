define([
    'common/modules/weather',
    'common/utils/config'
], function (
    weather,
    config
    ) {
    return function () {
        this.id = 'Weather';
        this.start = '2015-01-13';
        this.expiry = '2015-02-01';
        this.author = 'Steve Vadocz';
        this.description = 'Test the accuracy of weather location';
        this.audience = 0;
        this.audienceOffset = 0;
        this.successMeasure = 'The accuracy of the weather component is 100%';
        this.audienceCriteria = 'All users';
        this.dataLinkNames = 'weather';
        this.idealOutcome = 'Users will see they exact location';

        this.canRun = function () {
            return true;
        };

        this.variants = [
            {
                id: 'control',
                test: function () { }
            },
            {
                id: 'show',
                test: function () {
                    if (config.switches.weather) {
                        weather.init();
                    }
                }
            }
        ];
    };
});
