package mjg.tos

class TrekVulcan implements Vulcan {
    @Override
    def soothe() {
        println '''
            It seems to have a tranquilizing effect on the human nervous system.
            Fortunately, however, I am ... immune ... to its effects'''
        return null
    }

    @Override
    boolean decideIfLogical() {
        return Math.random() > 0.5
    }

    static String defaultReaction() {
        "raises eyebrow"
    }
}
